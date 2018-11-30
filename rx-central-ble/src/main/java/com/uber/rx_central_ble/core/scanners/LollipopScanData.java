/**
 *  Copyright (c) 2018 Uber Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.uber.rx_central_ble.core.scanners;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.support.annotation.Nullable;

import com.uber.rx_central_ble.ParsedAdvertisement;
import com.uber.rx_central_ble.ScanData;
import com.uber.rx_central_ble.Utils;
import com.uber.rx_central_ble.core.CoreParsedAdvertisement;

import java.io.UnsupportedEncodingException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

/**
 * Core implementation of ScanData interface.
 */
@TargetApi(21)
public class LollipopScanData implements ScanData {

  private final ScanResult scanResult;

  @Nullable
  private final ParsedAdvertisement parsedAdvertisement;

  public LollipopScanData(ScanResult scanResult, @Nullable ParsedAdvertisement parsedAdvertisement) {
    this.scanResult = scanResult;
    this.parsedAdvertisement = parsedAdvertisement;
  }

  @Override
  public int getRssi() {
    return scanResult.getRssi();
  }

  @Override
  public BluetoothDevice getBluetoothDevice() {
    return scanResult.getDevice();
  }

  @Override
  public ParsedAdvertisement getParsedAdvertisement() {
    return parsedAdvertisement;
  }

  @Override
  public ScanResult getScanResult() {
    return scanResult;
  }
}