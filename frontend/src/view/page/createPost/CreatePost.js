import React, { useState, useEffect } from "react";
import styles from "./CreatePost.module.css";
import FormButton from "../../element/formButton/FormButton";
import CreateTitle from "../../element/createTitle/CreateTitle";
import CreateText from "../../element/createText/CreateText";
import Alert from "../../element/alert/Alert";
import { useAddPost, useIsAuth, usePostIsAdded } from "../../../state/hook";
import { useNavigate } from "react-router-dom";

const CreatePost = () => {

  const [title, setTitle] = useState("");
  const [text, setText] = useState("");
  const navigate = useNavigate();
  const isAuth = useIsAuth();
  const addPost = useAddPost();
  const postIsAdded = usePostIsAdded();

  useEffect(() => {
    if(!isAuth){
        navigate('/auth');
    }
}, [isAuth, navigate])

  return (
    <div className={styles.container}>
      {postIsAdded !== null && (
        <Alert
          type={postIsAdded ? "success" : "error"}
          message={
            postIsAdded
              ? "Статья добавлена!"
              : "Произошла ошибка. Попробуйте позже."
          }
        />
      )}
      <h1>Создание поста</h1>
        <CreateTitle
          titleName="Заголовок:"
          onChange={setTitle}
        />
        <CreateText
          textName="Содержимое:"
          onChange={setText}
        />
        <FormButton
          text="Создать"
          onClick={() => addPost(title, text)}
        />
        <FormButton
          text="Назад"
          onClick={() => navigate('/main')}
        />
    </div>
  );
};

export default CreatePost;