import styles from './FormElement.module.css';

function FormElement(props){
    return (
        <label className={styles.label}>
            {props.label}
            <input type={props.type} className={styles.input} onChange={e => props.onChange(e.target.value)}/>
        </label>
    )
}

export default FormElement;