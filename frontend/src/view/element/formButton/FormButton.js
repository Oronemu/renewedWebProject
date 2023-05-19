import styles from './FormButton.module.css';

function FormButton(props){
    return (
        <button className={styles.button} onClick={props.onClick}>
            {props.text}
        </button>
    )
}

export default FormButton;