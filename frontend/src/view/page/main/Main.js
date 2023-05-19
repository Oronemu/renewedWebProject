import { useEffect } from 'react';
import {
  useConnectNotification,
  useDisconnectNotification,
  useGetPosts,
  useIsAuth,
  usePostsListener
} from '../../../state/hook';
import { useNavigate } from 'react-router-dom';
import Lenta from '../../element/lenta/Lenta';
import NavigationPanel from '../../element/navigationPanel/NavigationPanel';
import styles from './Main.module.css';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

function Main(props) {
  const isAuth = useIsAuth();
  const navigate = useNavigate();
  const getPosts = useGetPosts();
  const posts = usePostsListener();

  const connectNotification = useConnectNotification();
  const disconnectNotification = useDisconnectNotification();

  useEffect(() => {
    if (!isAuth) {
      navigate('/auth');
    }
  }, [isAuth, navigate]);

  useEffect(() => {
    getPosts();
  }, [getPosts]);

  useEffect(() => {
    connectNotification((notification) => {
      toast.info(notification);
    });
    return () => {
      disconnectNotification();
    };
  }, []);

  return (
    <div>
      <ToastContainer
        position="top-center"
        theme="dark"
        autoClose={3000}
        draggable
        pauseOnFocusLoss={false}
      />
      <NavigationPanel />
      <div className={styles.posts}>
        <Lenta posts={posts} />
      </div>
    </div>
  );
}

export default Main;
