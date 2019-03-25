/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package java.sql;

/**
 * Interface used to indicate that this object represents a Sharding Key. A
 * {@code ShardingKey} instance is only guaranteed to be compatible with the
 * data source instance that it was derived from. A {@code ShardingKey} is
 * created using {@link ShardingKeyBuilder}.
 * <p>
 * The following example illustrates the use of {@link ShardingKeyBuilder} to
 * create a {@code ShardingKey}:
 * <pre>
 * {@code
 *
 *     DataSource ds = new MyDataSource();
 *     ShardingKey shardingKey = ds.createShardingKeyBuilder()
 *                           .subkey("abc", JDBCType.VARCHAR)
 *                           .subkey(94002, JDBCType.INTEGER)
 *                           .build();
 * }
 * </pre>
 * <p>
 *
 * A {@code ShardingKey} may also be used for specifying a
 * {@code superShardingKey}. Databases that support composite Sharding may use a
 * {@code superShardingKey} to specify a additional level of partitioning within
 * the Shard.
 * <p>
 * The following example illustrates the use of {@link ShardingKeyBuilder} to
 * create a {@code superShardingKey} for an eastern region with a
 * {@code ShardingKey} specified for the Pittsburgh branch office:
 * <pre>
 * {@code
 *
 *     DataSource ds = new MyDataSource();
 *     ShardingKey superShardingKey = ds.createShardingKeyBuilder()
 *                           .subkey("EASTERN_REGION", JDBCType.VARCHAR)
 *                           .build();
 *     ShardingKey shardingKey = ds.createShardingKeyBuilder()
 *                           .subkey("PITTSBURGH_BRANCH", JDBCType.VARCHAR)
 *                           .build();
 *     Connection con = ds.createConnectionBuilder()
 *                           .superShardingKey(superShardingKey)
 *                           .shardingKey(shardingKey)
 *                           .build();
 * }
 * </pre>
 *
 * @since 9
 */
public interface ShardingKey {

}
