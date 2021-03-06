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
package io.streamsthoughts.azkarra.commons.error;

/**
 * The default record-headers added to record write to the dead-letter-topic.
 */
public class ExceptionHeader {

    public static final String STACKTRACE = "_exception.stacktrace";
    public static final String MESSAGE    = "_exception.message";
    public static final String CLASS_NAME = "_exception.class";
    public static final String TIMESTAMP  = "_exception.timestamp";

}
