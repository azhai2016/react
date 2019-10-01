import { NativeModules } from 'react-native';

const ZBar = NativeModules.ZBar;



//export default class ZBarComponent {

  // static startScan(options, cb) {
  //   console.log(options);
  //   return ZBar.startScan(options, cb);
  // }
 //}

module.exports = {
  startScan:(callback) => {
    console.log(NativeModules.ZBar);
    return ZBar.startScan(callback);
  }
}
