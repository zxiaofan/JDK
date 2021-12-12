/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

/*
 * Created on Apr 28, 2005
 */
package javax.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventObject;

/**
 * A {@code StatementEvent} is sent to all {@code StatementEventListener}s which were
 * registered with a {@code PooledConnection}. This occurs when the driver determines that a
 * {@code PreparedStatement} that is associated with the {@code PooledConnection} has been closed or the driver determines
 * is invalid.
 *
 * @since 1.6
 */
public class StatementEvent extends EventObject {

        static final long serialVersionUID = -8089573731826608315L;
        /**
         * The {@code SQLException} the driver is about to throw to the application.
         */
        private SQLException            exception;

        /**
         * The {@code PreparedStatement} that is being closed or is invalid.
         */
        @SuppressWarnings("serial") // Not statically typed as Serializable
        private PreparedStatement       statement;

        /**
         * Constructs a {@code StatementEvent} with the specified {@code PooledConnection} and
         * {@code PreparedStatement}.  The {@code SQLException} contained in the event defaults to
         * null.
         *
         * @param con                   The {@code PooledConnection} that the closed or invalid
         * {@code PreparedStatement}is associated with.
         * @param statement             The {@code PreparedStatement} that is being closed or is invalid
         *
         * @throws IllegalArgumentException if {@code con} is null.
         *
         * @since 1.6
         */
        public StatementEvent(PooledConnection con,
                                                  PreparedStatement statement) {

                super(con);

                this.statement = statement;
                this.exception = null;
        }

        /**
         * Constructs a {@code StatementEvent} with the specified {@code PooledConnection},
         * {@code PreparedStatement} and {@code SQLException}
         *
         * @param con                   The {@code PooledConnection} that the closed or invalid {@code PreparedStatement}
         * is associated with.
         * @param statement             The {@code PreparedStatement} that is being closed or is invalid
         * @param exception             The {@code SQLException }the driver is about to throw to
         *                                              the application
         *
         * @throws IllegalArgumentException if {@code con} is null.
         *
         * @since 1.6
         */
        public StatementEvent(PooledConnection con,
                                                  PreparedStatement statement,
                                                  SQLException exception) {

                super(con);

                this.statement = statement;
                this.exception = exception;
        }

        /**
         * Returns the {@code PreparedStatement} that is being closed or is invalid
         *
         * @return      The {@code PreparedStatement} that is being closed or is invalid
         *
         * @since 1.6
         */
        public PreparedStatement getStatement() {

                return this.statement;
        }

        /**
         * Returns the {@code SQLException} the driver is about to throw
         *
         * @return      The {@code SQLException} the driver is about to throw
         *
         * @since 1.6
         */
        public SQLException getSQLException() {

                return this.exception;
        }
}
