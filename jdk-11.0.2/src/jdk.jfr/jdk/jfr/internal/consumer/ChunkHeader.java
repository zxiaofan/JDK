/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package jdk.jfr.internal.consumer;

import java.io.DataInput;
import java.io.IOException;

import jdk.jfr.internal.LogLevel;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;
import jdk.jfr.internal.MetadataDescriptor;

public final class ChunkHeader {
    private static final long METADATA_TYPE_ID = 0;
    private static final byte[] FILE_MAGIC = { 'F', 'L', 'R', '\0' };

    private final short major;
    private final short minor;
    private final long chunkSize;
    private final long chunkStartTicks;
    private final long ticksPerSecond;
    private final long chunkStartNanos;
    private final long metadataPosition;
 //   private final long absoluteInitialConstantPoolPosition;
    private final long absoluteChunkEnd;
    private final long absoluteEventStart;
    private final long absoluteChunkStart;
    private final boolean lastChunk;
    private final RecordingInput input;
    private final long durationNanos;
    private final long id;
    private long constantPoolPosition;

    public ChunkHeader(RecordingInput input) throws IOException {
        this(input, 0, 0);
    }

    private ChunkHeader(RecordingInput input, long absoluteChunkStart, long id) throws IOException {
        input.position(absoluteChunkStart);
        if (input.position() >= input.size()) {
            throw new IOException("Chunk contains no data");
        }
        verifyMagic(input);
        this.input = input;
        this.id = id;
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk " + id);
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: startPosition=" + absoluteChunkStart);
        major = input.readRawShort();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: major=" + major);
        minor = input.readRawShort();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: minor=" + minor);
        if (major != 1 && major != 2) {
            throw new IOException("File version " + major + "." + minor + ". Only Flight Recorder files of version 1.x and 2.x can be read by this JDK.");
        }
        chunkSize = input.readRawLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: chunkSize=" + chunkSize);
        this.constantPoolPosition = input.readRawLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: constantPoolPosition=" + constantPoolPosition);
        metadataPosition = input.readRawLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: metadataPosition=" + metadataPosition);
        chunkStartNanos = input.readRawLong(); // nanos since epoch
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: startNanos=" + chunkStartNanos);
        durationNanos = input.readRawLong(); // duration nanos, not used
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: durationNanos=" + durationNanos);
        chunkStartTicks = input.readRawLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: startTicks=" + chunkStartTicks);
        ticksPerSecond = input.readRawLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.INFO, "Chunk: ticksPerSecond=" + ticksPerSecond);
        input.readRawInt(); // features, not used

        // set up boundaries
        this.absoluteChunkStart = absoluteChunkStart;
        absoluteChunkEnd = absoluteChunkStart + chunkSize;
        lastChunk = input.size() == absoluteChunkEnd;
        absoluteEventStart = input.position();

        // read metadata
        input.position(absoluteEventStart);
    }

    public ChunkHeader nextHeader() throws IOException {
        return new ChunkHeader(input, absoluteChunkEnd, id + 1);
    }

    public MetadataDescriptor readMetadata() throws IOException {
        input.position(absoluteChunkStart + metadataPosition);
        input.readInt(); // size
        long id = input.readLong(); // event type id
        if (id != METADATA_TYPE_ID) {
            throw new IOException("Expected metadata event. Type id=" + id + ", should have been " + METADATA_TYPE_ID);
        }
        input.readLong(); // start time
        input.readLong(); // duration
        long metadataId = input.readLong();
        Logger.log(LogTag.JFR_SYSTEM_PARSER, LogLevel.TRACE, "Metadata id=" + metadataId);
        // No need to read if metadataId == lastMetadataId, but we
        // do it for verification purposes.
        return MetadataDescriptor.read(input);
    }

    public boolean isLastChunk() {
        return lastChunk;
    }

    public short getMajor() {
        return major;
    }

    public short getMinor() {
        return minor;
    }

    public long getAbsoluteChunkStart() {
        return absoluteChunkStart;
    }

    public long getConstantPoolPosition() {
        return constantPoolPosition;
    }

    public long getStartTicks() {
        return chunkStartTicks;
    }

    public double getTicksPerSecond() {
        return ticksPerSecond;
    }

    public long getStartNanos() {
        return chunkStartNanos;
    }

    public long getEnd() {
        return absoluteChunkEnd;
    }

    public long getSize() {
        return chunkSize;
    }

    public long getDuration() {
        return durationNanos;
    }

    public RecordingInput getInput() {
        return input;
    }

    private static void verifyMagic(DataInput input) throws IOException {
        for (byte c : FILE_MAGIC) {
            if (input.readByte() != c) {
                throw new IOException("Not a Flight Recorder file");
            }
        }
    }

    public long getEventStart() {
        return absoluteEventStart;
    }

}
