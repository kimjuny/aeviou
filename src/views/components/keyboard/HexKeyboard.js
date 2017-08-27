import React from 'react';
import { View } from 'react-native';
import HexKeyRow from './HexKeyRow';
import keys from '../../utils/keys';
import styles from './styles/HexKeyboard';

const HexKeyboard = () => {
  return (
    <View style={styles['hex-keyboard']}>
      { keys.layout.map((row, i) => <HexKeyRow key={i} keys={row} />) }
    </View>
  );
};

export default HexKeyboard;
