import { combineReducers } from "redux";
import reducerUser from "./user/reducer";
import reducerPost from "./post/reducer";

const appReducer = combineReducers({
    user: reducerUser,
    post: reducerPost
})

const rootReducer = (state, action) => {
    if (action.type === "test") {
      return appReducer(undefined, action);
    }
    return appReducer(state, action);
}

export default rootReducer;