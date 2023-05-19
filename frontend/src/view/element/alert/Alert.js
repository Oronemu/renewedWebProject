import React from "react";
import styles from "./Alert.module.css";

const Alert = ({ type, message }) => {
  const alertClassName =
    type === "success" ? styles.success : styles.error;

  return <div className={`${styles.container} ${alertClassName}`}>{message}</div>;
};

export default Alert;