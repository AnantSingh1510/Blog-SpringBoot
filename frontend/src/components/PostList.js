import React, { useState, useEffect } from 'react';
import axios from 'axios';
import PostDetails from './PostDetails';

const PostList = () => {
  const [loading, setLoading] = useState(true);
  const [posts, setPosts] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchPosts = async () => {
      try {
        const response = await axios.get('http://localhost:8080/api/posts');
        setPosts(response.data);
        setLoading(false);
      } catch (error) {
        setError(error.message);
        setLoading(false);
      }
    };

    // Fetch posts initially
    fetchPosts();

    // Fetch posts every 10 seconds
    const intervalId = setInterval(fetchPosts, 10000);

    // Clean up the interval on component unmount
    return () => clearInterval(intervalId);
  }, []);

  if (loading) {
    return <div>Loading...</div>;
  }

  if (error) {
    return <div>Error fetching posts: {error}</div>;
  }

  return <PostDetails posts={posts} />;
};

export default PostList;
