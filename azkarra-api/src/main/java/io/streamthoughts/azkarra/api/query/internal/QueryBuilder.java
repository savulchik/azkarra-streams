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
package io.streamthoughts.azkarra.api.query.internal;

import java.util.Objects;

public class QueryBuilder {

    private final String storeName;

    /**
     * Creates a new {@link QueryBuilder} instance.
     *
     * @param storeName the store name to query.
     */
    public QueryBuilder(final String storeName) {
        Objects.requireNonNull(storeName, "storeName cannot be null");
        this.storeName = storeName;
    }

    /**
     * Key-Value storeName.
     */
    public KeyValueQueryBuilder keyValue() {
        return new KeyValueQueryBuilder(storeName);
    }

    /**
     * Session storeName.
     */
    public SessionQueryBuilder session() {
        return new SessionQueryBuilder(storeName);
    }

    /**
     * Window storeName.
     */
    public WindowQueryBuilder window() {
        return new WindowQueryBuilder(storeName);
    }

    /**
     * Timestamped Key-Value storeName.
     */
    public void timestampedKeyValue() {
        throw new UnsupportedOperationException();
    }

    /**
     * Timestamped Window storeName
     */
    public void timestampedWindow() {
        throw new UnsupportedOperationException();
    }




}
