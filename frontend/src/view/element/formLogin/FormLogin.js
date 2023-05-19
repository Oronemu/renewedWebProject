import styles from './FormLogin.module.css';
import FormElement from '../formElement/FormElement';
import FormButton from '../formButton/FormButton';
import { useState } from 'react';
import { useSignIn, useMessageAuthListener} from '../../../state/hook';
import ErrorMessage from '../errorMessage/ErrorMessage';

function FormLogin(props){

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const signIn = useSignIn();
    const messageAuth = useMessageAuthListener();

    return (
        <div className={styles.auth}>
          <h2 className={styles.title}>Вход на сайт</h2>
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
                text="Войти"
                onClick={() => signIn(username, password)}
            />
        </div>
      );
}

export default FormLogin;