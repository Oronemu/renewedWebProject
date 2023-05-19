import { addPostRequest, getAllPosts } from "../../model/post/Post";

export const GET_POSTS = 'GET_POSTS';
export const ADD_POST = 'ADD_POST';

const createState = (type, payload) => {
    return {
        type,
        payload
    }
}

export const getPosts = () => {
    return dispatch => {
        getAllPosts()
        .then((posts) => {
            dispatch(createState(GET_POSTS, {
                posts: posts,
            }))
        })
        .catch(() => {
            dispatch(createState(GET_POSTS, {
                postsError: true
            }))
        })
    }
}

export const addPost = (title, text) => {
    return dispatch => {
        addPostRequest(title, text)
        .then(() => {
            dispatch(createState(ADD_POST, true));
        })
        .catch(() => {
            dispatch(createState(ADD_POST, false));
        })
    }
}