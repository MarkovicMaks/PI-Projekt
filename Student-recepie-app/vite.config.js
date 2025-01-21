import { defineConfig } from 'vite';
import react from '@vitejs/plugin-react';

export default defineConfig({
  plugins: [react()],
  test: {
    globals: true,
    environment: 'jsdom', 
    coverage: {
      provider: 'c8', 
      reportsDirectory: 'coverage', 
      all: true, 
      exclude: [
        'node_modules/',
        'src/**/*.test.{js,ts,jsx,tsx}',
        'src/**/__tests__/**', 
        'src/main.{js,ts,jsx,tsx}',
      ],
    },
  },
});
