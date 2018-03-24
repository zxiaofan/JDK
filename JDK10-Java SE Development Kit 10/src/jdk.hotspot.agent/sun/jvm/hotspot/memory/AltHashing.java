/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.memory;

public class AltHashing {
    public static long murmur3_32(long seed, byte[] data) {
      long h1 = seed;
      int len = data.length;
      int count = len;

      int offset = 0;

      // body
      while (count >= 4) {
          long k1 = (data[offset] & 0x0FF)
              | (data[offset + 1] & 0x0FF) << 8
              | (data[offset + 2] & 0x0FF) << 16
              | data[offset + 3] << 24;

          count -= 4;
          offset += 4;

          k1 *= 0xcc9e2d51;
          k1 = Integer.rotateLeft((int)k1, 15);
          k1 *= 0x1b873593;
          k1 &= 0xFFFFFFFFL;

          h1 ^= k1;
          h1 = Integer.rotateLeft((int)h1, 13);
          h1 = h1 * 5 + 0xe6546b64;
          h1 &= 0xFFFFFFFFL;
      }

      //tail
      if (count > 0) {
          long k1 = 0;

          switch (count) {
              case 3:
                  k1 ^= (data[offset + 2] & 0xff) << 16;
                  // fall through
              case 2:
                  k1 ^= (data[offset + 1] & 0xff) << 8;
                  // fall through
              case 1:
                  k1 ^= (data[offset] & 0xff);
                  // fall through
              default:
                  k1 *= 0xcc9e2d51;
                  k1 = Integer.rotateLeft((int)k1, 15);
                  k1 *= 0x1b873593;
                  k1 &= 0xFFFFFFFFL;
                  h1 ^= k1;
                  h1 &= 0xFFFFFFFFL;
          }
      }

      // finalization
      h1 ^= len;

      // finalization mix force all bits of a hash block to avalanche
      h1 ^= h1 >> 16;
      h1 *= 0x85ebca6b;
      h1 &= 0xFFFFFFFFL;
      h1 ^= h1 >> 13;
      h1 *= 0xc2b2ae35;
      h1 &= 0xFFFFFFFFL;
      h1 ^= h1 >> 16;

      return h1 & 0xFFFFFFFFL;
  }
}
