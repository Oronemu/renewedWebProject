import * as actions from './actions';

const initialState = {
    notificationsIsOn: false
}

export default function reducerPost(state= initialState, action){
    switch (action.type) {
        case actions.CONNECT_NOTIFICATIONS:
            return {
                ...state,
                notificationsIsOn: true
            }
        case actions.DISCONNECT_NOTIFICATIONS:
            return {
                ...state,
                notificationsIsOn: false
            }
        default:
            return state;
    }
}