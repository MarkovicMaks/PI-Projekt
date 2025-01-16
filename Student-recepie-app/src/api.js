import axios from "axios";

// Base URL for your backend API
const API_URL = "http://localhost:8080/api/recipes";

// Fetch all recipes
export const getAllRecipes = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error("Error fetching all recipes:", error);
        throw error;
    }
};

// Fetch a single recipe by ID
export const getRecipeById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error(`Error fetching recipe with ID ${id}:`, error);
        throw error;
    }
};

// Add a new recipe
export const createRecipe = async (recipeData) => {
    try {
        const response = await axios.post(API_URL, recipeData, {
            headers: {
                "Content-Type": "application/json",
            },
        });
        return response.data;
    } catch (error) {
        console.error("Error creating a new recipe:", error);
        throw error;
    }
};

// Delete a recipe by ID
export const deleteRecipe = async (id) => {
    try {
        await axios.delete(`${API_URL}/${id}`);
    } catch (error) {
        console.error(`Error deleting recipe with ID ${id}:`, error);
        throw error;
    }
};
