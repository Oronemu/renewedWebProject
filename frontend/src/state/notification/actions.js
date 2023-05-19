import { closeNotification, connectNotification } from "../../model/notification/Notification";

export const CONNECT_NOTIFICATIONS = 'CONNECT_NOTIFICATIONS';
export const DISCONNECT_NOTIFICATIONS = 'DISCONNECT_NOTIFICATIONS';

const createState = (type, payload) => {
    return {
        type,
        payload
    }
}

export const connect = (callback) => {
    return dispatch => {
        connectNotification(callback);
        dispatch(createState(CONNECT_NOTIFICATIONS));
    }
}

export const disconnect = () => {
    return dispatch => {
        closeNotification();
        dispatch(createState(DISCONNECT_NOTIFICATIONS));
    }
}