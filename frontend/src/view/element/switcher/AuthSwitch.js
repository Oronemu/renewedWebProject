import styles from './AuthSwitch.module.css';

function AuthSwitch(props) {
  return (
    <div className={styles.switch}>
        <span
        className={`${styles.option} ${props.activeOption === 'login' && styles.active}`}
        onClick={() => props.onChange(true)}
        >  Вход </span>
        <span
        className={`${styles.option} ${props.activeOption === 'register' && styles.active}`}
        onClick={() => props.onChange(false)}
        > Регистрация</span>
    </div>
  );
}

export default AuthSwitch;