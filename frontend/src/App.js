import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import PostList from './components/PostList';
import PostDetails from './components/PostDetails';
import AuthorList from './components/AuthorList';
import AuthorForm from './components/AuthorForm';
import PostForm from './components/PostForm';
import Home from './components/Home';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/posts" element={<PostList />} />
        <Route path="/posts/:postId" element={<PostDetails />} />
        <Route path="/authors" element={<AuthorList />} />
        <Route path="/authors/new" element={<AuthorForm />} />
        <Route path="/posts/new" element={<PostForm />} />
      </Routes>
    </Router>
  );
}

export default App;
