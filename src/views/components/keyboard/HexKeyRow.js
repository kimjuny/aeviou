import React, { PureComponent } from 'react';
import { View } from 'react-native';
import HexKey from '../key/HexKey';
import styles from './styles/HexKeyRow';

class HexKeyRow extends PureComponent {
  render() {
    const { keys } = this.props;
    return (
      <View style={styles.row}>
        { keys.map(key => <HexKey key={key.name} name={key.name} />) }
      </View>
    );
  }
}

export default HexKeyRow;
