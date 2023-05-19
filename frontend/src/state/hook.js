import { Provider as ReduxProvider, useDispatch, useSelector } from 'react-redux';
import store from './store';
import { sighInAction, signOutAction, signUpAction } from './user/actions';
import { addPost, getPosts } from './post/actions';
import { connect, disconnect } from './notification/actions';

function buildProvider(){
    return (props)=> {
        return (
            <ReduxProvider store = {store}>     
            {props.children}  
            </ReduxProvider>
        );
    };
}

function useSignIn(){
    const dispatch = useDispatch();
    return (username, password) => dispatch(sighInAction(username, password));
}

function useSignUp(){
    const dispatch = useDispatch();
    return (username, password) => dispatch(signUpAction(username, password));
}

function useIsAuth(){
    return useSelector((state) => state.user.isAuth);
}

function useMessageAuthListener(){
    return useSelector(state => state.user.messageAuth);
}

function useSignOut(){
    const dispatch = useDispatch();
    return () => dispatch(signOutAction());
}

export {
    buildProvider,
    useSignIn,
    useIsAuth,
    useMessageAuthListener,
    useSignUp,
    useSignOut
}

function useGetPosts(){
    const dispatch = useDispatch();
    return () => dispatch(getPosts());
}

function usePostsListener(){
    return useSelector(state => state.post.posts);
}

function usePostsErrorListener(){
    return useSelector(state => state.post.postsError);
}

function useAddPost(){
    const dispatch = useDispatch();
    return (title, text) => dispatch(addPost(title, text));
}

function usePostIsAdded(){
    return useSelector(state => state.post.postIsAdded);
}

export {
    useGetPosts,
    usePostsListener,
    usePostsErrorListener,
    useAddPost,
    usePostIsAdded
}

function useNotificationsIsOn(){
    return useSelector(state => state.notification.notificationsIsOn);
}

function useConnectNotification(){
    const dispatch = useDispatch();
    return (callback) => dispatch(connect(callback));
}

function useDisconnectNotification(){
    const dispatch = useDispatch();
    return (callback) => dispatch(disconnect(callback));
}

export {
    useNotificationsIsOn,
    useConnectNotification,
    useDisconnectNotification
}