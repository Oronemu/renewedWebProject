import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Auth from './view/page/auth/Auth';
import { buildProvider } from './state/hook';
import styles from './App.css';
import Main from './view/page/main/Main';
import CreatePost from './view/page/createPost/CreatePost';

const Provider = buildProvider();

function App() {
  return (
    <div className={styles.app}>
      <Provider>
        <BrowserRouter>
          <Routes>
            <Route path="/"element={<Auth/>}/>
            <Route path="/auth"element={<Auth/>}/>
            <Route path="/main"element={<Main/>}/>
            <Route path="/create"element={<CreatePost/>}/>
          </Routes>
        </BrowserRouter>
      </Provider>
    </div>
  );
}

export default App;
