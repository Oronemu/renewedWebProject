import styles from './CreateTitle.module.css';

function CreateTitle(props){
    return (
        <div className={styles.formGroup}>
          <label className={styles.label}>{props.titleName}</label>
          <input
            className={styles.input}
            type="text"
            onChange={(e) => props.onChange(e.target.value)}
            required
          />
        </div>
    )
}

export default CreateTitle;