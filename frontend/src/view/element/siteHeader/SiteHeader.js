import styles from './SiteHeader.module.css';

function SiteHeader(props) {
  return (
    <header className={styles.header}>
      <div className={styles.logo}>
        <img src={props.logoUrl} alt={props.siteName} />
        <h1>{props.siteName}</h1>
      </div>
    </header>
  );
}

export default SiteHeader;