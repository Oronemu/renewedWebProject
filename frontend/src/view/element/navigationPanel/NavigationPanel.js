import React from "react";
import styles from "./NavigationPanel.module.css";
import { useNavigate } from "react-router-dom";
import { useSignOut } from "../../../state/hook";

function NavigationPanel() {

    const navigate = useNavigate();
    const signOut = useSignOut();

    return (
      <header className={styles.header}>
        <div className={styles.logo}>Хабр</div>
        <nav className={styles.nav}>
          <ul className={styles.navList}>
            <li className={styles.navItem}>
              <a className={styles.navLink} onClick={() => navigate('/create')}>Создать статью</a>
            </li>
            <li className={styles.navItem}>
              <a className={styles.navLink} onClick={signOut}>Выйти</a>
            </li>
          </ul>
        </nav>
      </header>
    );
  }
  
  export default NavigationPanel;