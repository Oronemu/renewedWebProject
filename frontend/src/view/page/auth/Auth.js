import { useEffect, useState } from 'react';
import { useIsAuth } from '../../../state/hook';
import FormLogin from '../../element/formLogin/FormLogin';
import styles from './Auth.module.css';
import SiteHeader from '../../element/siteHeader/SiteHeader';
import Switcher from '../../element/switcher/AuthSwitch';
import FormRegister from '../../element/formRegister/FormRegister';
import { useNavigate } from 'react-router-dom';

function Auth(props) {
  const [isLogin, setIsLogin] = useState(true);
  const isAuth = useIsAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (isAuth) {
      navigate('/main');
    }
  }, [isAuth, navigate]);

  return (
    <div className={styles.auth}>
      <SiteHeader
        logoUrl="https://habrastorage.org/files/df0/491/ba4/df0491ba483b4446bc9261be83f69ebd.png"
        siteName="Хабр"
      />
      <Switcher
        activeOption={isLogin ? 'login' : 'register'}
        onChange={setIsLogin}
      />
      {isLogin ? <FormLogin /> : <FormRegister />}
    </div>
  );
}

export default Auth;
