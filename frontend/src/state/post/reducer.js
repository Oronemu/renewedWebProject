import * as actions from './actions';

const initialState = {
    posts: [],
    postsError: null,
    postIsAdded: null
}

export default function reducerPost(state= initialState, action){
    switch (action.type) {
        case actions.GET_POSTS:
            return {
                ...state,
                posts: action.payload.posts,
                postsError: action.payload.postsError
            }
        case actions.ADD_POST:
            return {
                ...state,
                postIsAdded: action.payload
            }
        default:
            return state;
    }
}