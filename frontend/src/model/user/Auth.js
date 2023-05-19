import { API_URL } from "../../config"

export const signIn = async (username, password) => {
    try {
        const response = await fetch(API_URL + '/users/signIn', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json;charset=UTF-8'
          },
          body: JSON.stringify({ username, password })
        });
    
        const data = await response.json();
        let res;
        if(response.ok){
          saveLoginAndToken(username, data);
          res = {
            status: response.status,
          }
        } else {
          res = {
            status: response.status,
            data: data
          }
        }
        return Promise.resolve(res);
      } catch (error) {
        console.log(error);
        return Promise.reject();
      }
}

export const signUp = async (username, password) => {
  try {
      const response = await fetch(API_URL + '/users/signUp', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json;charset=UTF-8'
        },
        body: JSON.stringify({ username, password })
      });
  
      const data = await response.json();
      let res;
      if(response.ok){
        saveLoginAndToken(username, data);
        res = {
          status: response.status,
        }
      } else {
        res = {
          status: response.status,
          data: data
        }
      }
      return Promise.resolve(res);
    } catch (error) {
      console.log(error);
      return Promise.reject();
    }
}

export const signOut = () => {
  localStorage.removeItem('token');
  localStorage.removeItem('username');
}

export const getUsername = () => {
  return localStorage.getItem('username');
}

export const getToken = () => {
  return localStorage.getItem('token');
}

const saveLoginAndToken = (username, token) => {
    localStorage.setItem('username', username);
    localStorage.setItem('token', token);
}