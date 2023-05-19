import { getToken } from '../../model/user/Auth';
import * as actions from './actions';

const initialState = {
    isAuth: getToken() != null ? true : false
}

export default function reducerUser(state = initialState, action){
    switch (action.type) {
       case actions.SIGN_IN:
           return {
               ...state,
               isAuth: action.payload.isAuth,
               messageAuth: action.payload.messageAuth
           }
        case actions.SIGN_UP:
            return {
                ...state,
                isAuth: action.payload.isAuth,
                messageAuth: action.payload.messageAuth
            }
        case actions.SIGN_OUT:
            return {
                ...state,
                isAuth: false
            }
       default:
           return state;
   }
}