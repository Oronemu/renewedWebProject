import React from 'react';
import styles from './Lenta.module.css';

function Lenta(props){

  return (
    <div className={styles.postFeed}>
      {props.posts.map((post, index) => (
        <div className={styles.post} key={index}>
          <h3 className={styles.title}>{post.title}</h3>
          <p className={styles.author}>Автор: @{post.author}</p>
          <p className={styles.author}>{post.date.slice(0, 10)}</p>
          <p className={styles.content}>{post.text}</p>
        </div>
      ))}
    </div>
  )
}

export default Lenta;
