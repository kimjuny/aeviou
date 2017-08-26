import React from 'react';
import { View, Text } from 'react-native';
import styles from './styles/Keyboard';

const Keyboard = () => (
  <View style={styles.container}>
    <Text style={styles.text}>This is the Keyboard container.</Text>
  </View>
);

export default Keyboard;
