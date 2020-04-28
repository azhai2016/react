
# react-native-zbar-android

Fast QR Code Scanner for Android based on https://github.com/ZBar/ZBar

## Installation Android
1. `yarn add https://git@github.com/azhai2016/react-nactive-zbar-android.git`
2. `react-native link react-native-zbar-android`  -- 可省略

# Usage

```js

import { startScan } from 'react-native-zbar-android'
import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  ToastAndroid,
  View
} from 'react-native';

class Demo extends Component {

   _onscan=()=>{
      startScan(this._onBarCodeRead.bind(this))
   }

  render () {
    return (
      <View>
        <Button onPress={this._onscan} ></Button>
      </View>
    )
  }

  _onBarCodeRead (QRCodeResult) {
    if (QRCodeResult.state === 'ok') {
      let result = QRCodeResult.code
      ToastAndroid.show(result, ToastAndroid.SHORT);
    }
  }
}

```

## Questions or suggestions?

Feel free to [open an issue](https://github.com/azhai2016/react-native-zbar-android/issues)
