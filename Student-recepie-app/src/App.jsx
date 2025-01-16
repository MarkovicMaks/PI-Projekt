import React, { useEffect, useState } from 'react';
import './App.css';
import RecepieNavbar from './Components/Navbar';
import RecepieCard from './Components/RecepieCard';
import FilterNavbar from './Components/FilterNavbar';
import { getAllRecipes } from './api'; // Import your API call

function HomePage() {
  const [recipes, setRecipes] = useState([]); // State to store fetched recipes
  const [loading, setLoading] = useState(true); // State for loading indicator
  const [error, setError] = useState(null); // State for error handling

  useEffect(() => {
    const fetchRecipes = async () => {
      try {
        const data = await getAllRecipes(); // Fetch data from the API
        setRecipes(data); // Set the fetched recipes in state
      } catch (err) {
        setError(err.message); // Set any errors
      } finally {
        setLoading(false); // Stop loading
      }
    };

    fetchRecipes();
  }, []); // Empty dependency array ensures this runs only once on component mount

  if (loading) return <p>Loading recipes...</p>; // Show loading text while fetching
  if (error) return <p>Error: {error}</p>; // Show error message if fetching fails

  return (
    <>
      <RecepieNavbar />
      <FilterNavbar />
      <div className="CardHolder">
        {/* Map over recipes and render a RecepieCard for each */}
        {recipes.map((recipe) => (
          <RecepieCard
            key={recipe.id} // Ensure each card has a unique key
            title={recipe.title}
            description={recipe.description}
            priceTag={recipe.priceTag}
            healthTag={recipe.healthTag}
            preferenceTag={recipe.preferenceTag}
            createdAt={recipe.createdAt}
          />
        ))}
      </div>
    </>
  );
}

export default HomePage;
