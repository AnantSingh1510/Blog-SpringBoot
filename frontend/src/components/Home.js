import React from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  return (
    <div>
      <h1>Welcome to Blog Application</h1>
      <Link to="/authors">
        <button>View Authors</button>
      </Link>
      <Link to="/posts">
        <button>View Posts</button>
      </Link>
      <Link to="/posts/new">
        <button>New Post</button>
      </Link>
    </div>
  );
};

export default Home;
