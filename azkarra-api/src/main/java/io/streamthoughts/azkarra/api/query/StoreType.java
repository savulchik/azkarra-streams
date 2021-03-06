/*
 * Copyright 2019 StreamThoughts.
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.streamthoughts.azkarra.api.query;

import io.streamthoughts.azkarra.api.query.internal.KeyValueQueryBuilder;
import io.streamthoughts.azkarra.api.query.internal.Query;
import io.streamthoughts.azkarra.api.query.internal.QueryBuilder;
import io.streamthoughts.azkarra.api.query.internal.WindowQueryBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * The storeName types supported by {@link org.apache.kafka.streams.KafkaStreams}.
 */
public enum StoreType {

    /**
     * Key-Value storeName.
     */
    KEY_VALUE {
        @Override
        @SuppressWarnings("unchecked")
        public <K, V> Query<K, V> buildQuery(final String storeName, final StoreOperation operation) {
            KeyValueQueryBuilder builder = new QueryBuilder(storeName).keyValue();
            return builder.operation(operation);
        }
    },
    /**
     * Window storeName.
     */
    WINDOW {
        @Override
        @SuppressWarnings("unchecked")
        public <K, V> Query<K, V>  buildQuery(final String storeName, final StoreOperation operation) {
            WindowQueryBuilder builder = new QueryBuilder(storeName).window();
            return builder.operation(operation);
        }
    },
    /**
     * Session storeName.
     */
    SESSION {
        @Override
        public <K, V> Query<K, V> buildQuery(final String storeName, final StoreOperation operation) {
            throw new UnsupportedOperationException();
        }
    },
    /**
     * Timestamped Key-Value storeName.
     */
    TIMESTAMPED_KEY_VALUE {
        @Override
        public <K, V> Query<K, V> buildQuery(final String storeName, final StoreOperation operation) {
            throw new UnsupportedOperationException();
        }
    },
    /**
     * Timestamped Window storeName
     */
    TIMESTAMPED_WINDOW {
        @Override
        public <K, V> Query<K, V> buildQuery(final String storeName, final StoreOperation operation) {
            throw new UnsupportedOperationException();
        }
    };

    private static final Map<String, StoreType> CACHE = new HashMap<>();

    static {
        Arrays.stream(StoreType.values())
              .forEach(t -> CACHE.put(t.name(), t));
    }


    public static Optional<StoreType> parse(final String storeType) {
        final String uppercased = storeType.toUpperCase();
        return Optional.ofNullable(CACHE.get(uppercased));
    }

    public abstract <K, V> Query<K, V> buildQuery(final String storeName, final StoreOperation operation);

    public String prettyName() {
        return name().toLowerCase();
    }
}
