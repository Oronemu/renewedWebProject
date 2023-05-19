import { signIn, signOut, signUp } from "../../model/user/Auth";

export const SIGN_IN = 'SIGN_IN';
export const SIGN_UP = 'SIGN_UP';
export const SIGN_OUT = 'SIGN_OUT';

const createState = (type, payload) => {
    return {
        type,
        payload
    }
}

export const signOutAction = () => {
    return dispatch => {
        signOut();
        dispatch(createState(SIGN_OUT));
    }
}

export const sighInAction = (username, password) => {
    return dispatch => {
        signIn(username, password)
        .then((res) => {
            dispatch(createState(SIGN_IN, {
                isAuth: res.status === 200 ? true : false,
                messageAuth: res.data
            }));
        })
        .catch(() => {
            dispatch(createState(SIGN_IN, {
                isAuth: false,
                messageAuth: "Ошибка сети"
            }));
        })
    }
}

export const signUpAction = (username, password) => {
    return dispatch => {
        signUp(username, password)
        .then((res) => {
            dispatch(createState(SIGN_UP, {
                isAuth: res.status === 200 ? true : false,
                messageAuth: res.data
            }));
        })
        .catch(() => {
            dispatch(createState(SIGN_UP, {
                isAuth: false,
                messageAuth: "Ошибка сети"
            }));
        })
    }
}