import styles from './CreateText.module.css';

function CreateText(props){
    return (
        <div className={styles.formGroup}>
          <label className={styles.label}>{props.textName}</label>
          <textarea
            className={styles.textarea}
            onChange={(e) => props.onChange(e.target.value)}
            required
          />
        </div>
    )
}

export default CreateText;