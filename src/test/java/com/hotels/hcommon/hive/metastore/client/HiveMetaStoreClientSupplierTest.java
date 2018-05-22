/**
 * Copyright (C) 2017-2018 Expedia Inc.
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
package com.hotels.hcommon.hive.metastore.client;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;

import org.apache.hadoop.hive.conf.HiveConf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class HiveMetaStoreClientSupplierTest {

  private @Mock MetaStoreClientFactory metaStoreClientFactory;
  private HiveConf hiveConf = new HiveConf();
  private String name = "HiveMetaStoreClient";

  @Test
  public void get() {
    HiveMetaStoreClientSupplier metaStoreClientSupplier = new HiveMetaStoreClientSupplier(metaStoreClientFactory,
        hiveConf, name);
    metaStoreClientSupplier.get();
    verify(metaStoreClientFactory).newInstance(eq(hiveConf), eq(name));
  }
}
