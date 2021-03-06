/**
 * Copyright (C) 2018-2020 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hotels.hcommon.hive.metastore.client.conditional;

import org.apache.hadoop.hive.conf.HiveConf;

import com.google.common.base.Strings;

import com.hotels.hcommon.hive.metastore.client.api.CloseableMetaStoreClient;
import com.hotels.hcommon.hive.metastore.client.api.ConditionalMetaStoreClientFactory;
import com.hotels.hcommon.hive.metastore.client.closeable.CloseableMetaStoreClientFactory;

public class ThriftHiveMetaStoreClientFactory implements ConditionalMetaStoreClientFactory {

  public static final String ACCEPT_PREFIX = "thrift:";

  @Override
  public boolean accepts(String uri) {
    return Strings.nullToEmpty(uri).startsWith(ACCEPT_PREFIX);
  }

  @Override
  public CloseableMetaStoreClient newInstance(HiveConf conf, String name) {
    return new CloseableMetaStoreClientFactory().newInstance(conf, name);
  }
}
