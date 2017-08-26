import React from 'react';
import { View } from 'react-native';
import HexKeyboard from '../components/keyboard/HexKeyboard';
import styles from './styles/IME';

const IME = () => (
  <View style={styles.ime}>
    <View />
    <View style={styles.container}>
      <HexKeyboard />
    </View>
  </View>
);

export default IME;
