import { API_URL } from "../../config"
import { getToken, getUsername } from "../user/Auth";

export const getAllPosts = async () => {
    try {
        const response = await fetch(API_URL + '/posts', {
          method: 'GET',
          headers: {
            'Content-Type': 'application/json;charset=UTF-8',
            username: getUsername(),
            token: getToken()
          }
        });
    
        const data = await response.json();
        return Promise.resolve(data);
      } catch (error) {
        console.log(error);
        return Promise.reject();
      }
}

export const addPostRequest = async (title, text) => {
  try {
    const response = await fetch(API_URL + '/posts', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json;charset=UTF-8',
        username: getUsername(),
        token: getToken(),
      },
      body: JSON.stringify({ title, text, author: getUsername() })
    });
    return Promise.resolve();
  } catch (error) {
    console.log(error);
    return Promise.reject();
  }
}
