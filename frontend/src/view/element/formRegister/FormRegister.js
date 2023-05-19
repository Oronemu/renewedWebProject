import { useState } from "react";
import styles from './FormRegister.module.css';
import FormElement from "../formElement/FormElement";
import FormButton from "../formButton/FormButton";
import ErrorMessage from "../errorMessage/ErrorMessage";
import { useSignUp, useMessageAuthListener } from "../../../state/hook";

function FormRegister(props){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const signUp = useSignUp();
    const messageAuth = useMessageAuthListener();

    return (
        <div className={styles.auth}>
          <h2 className={styles.title}>Регистрация</h2>
            <FormElement
                label="Никнейм"
                type="text"
                onChange={setUsername}
            />
            <FormElement
                label="Пароль"
                type="password"
                onChange={setPassword}
            />
            {messageAuth && <ErrorMessage message={messageAuth}/>}
            <FormButton
                text="Зарегистрироваться"
                onClick={() => signUp(username, password)}
            />
        </div>
    )
}

export default FormRegister;