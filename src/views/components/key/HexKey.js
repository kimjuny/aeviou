import React from 'react';
import {
  Text, TouchableOpacity, NativeModules, View,
} from 'react-native';

class HexKey extends React.PureComponent {
  onPress() {
    const { name } = this.props;
    const { Aeviou } = NativeModules;
    Aeviou.write(name);
  }

  render() {
    const { name } = this.props;
    return (
      <TouchableOpacity
        onPress={this.onPress.bind(this)}
      >
        <Text>{ name }</Text>
      </TouchableOpacity>
    );
  }
}

export default HexKey;
