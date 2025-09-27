#!/bin/bash

# Complete Blog API Test Script using cURL
# Make sure your Spring Boot application is running on localhost:8080

echo "🚀 Testing Blog APIs with cURL..."
echo ""

BASE_URL="http://localhost:8080/api/blogs"

# Test 1: Get all published blogs (Public)
echo "1. Testing GET /api/blogs/public - Get all published blogs"
curl -s -X GET "$BASE_URL/public" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 2: Get featured blogs
echo "2. Testing GET /api/blogs/public/featured - Get featured blogs"
curl -s -X GET "$BASE_URL/public/featured" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 3: Get blog by slug (Public)
echo "3. Testing GET /api/blogs/public/slug/{slug} - Get blog by slug"
curl -s -X GET "$BASE_URL/public/slug/acne-causes-signs-ayurvedic-treatment" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 4: Search published blogs
echo "4. Testing GET /api/blogs/public/search?keyword=acne - Search blogs"
curl -s -X GET "$BASE_URL/public/search?keyword=acne" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 5: Get blogs by author
echo "5. Testing GET /api/blogs/public/author/{author} - Get blogs by author"
curl -s -X GET "$BASE_URL/public/author/Dr.%20Axico" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

echo "🔐 ADMIN ENDPOINTS"
echo ""

# Test 6: Get all blogs (Admin)
echo "6. Testing GET /api/blogs/admin - Get all blogs (admin)"
curl -s -X GET "$BASE_URL/admin" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 7: Get blog by ID (Admin)
echo "7. Testing GET /api/blogs/admin/1 - Get blog by ID"
curl -s -X GET "$BASE_URL/admin/1" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 8: Create new blog (Admin)
echo "8. Testing POST /api/blogs/admin - Create new blog"
curl -s -X POST "$BASE_URL/admin" \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "title": "Test Blog from cURL",
    "slug": "test-blog-curl",
    "content": "This is a test blog created using cURL script to test the API endpoints.",
    "summary": "A test blog created via cURL to verify API functionality",
    "author": "cURL Tester",
    "imageUrl": "https://images.unsplash.com/photo-1545558014-8692077e9b5c?auto=format&fit=crop&w=1000&q=80",
    "tags": "test, api, curl, ayurveda",
    "published": true,
    "featured": false
  }' | head -c 200
echo -e "\n✅ Test completed\n"

# Test 9: Update blog (Admin) - using blog ID 3 (assuming it was created)
echo "9. Testing PUT /api/blogs/admin/3 - Update blog"
curl -s -X PUT "$BASE_URL/admin/3" \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "title": "Updated Test Blog from cURL",
    "slug": "updated-test-blog-curl",
    "content": "This is an UPDATED test blog created using cURL script.",
    "summary": "Updated test blog to verify API update functionality",
    "author": "cURL Tester Updated",
    "imageUrl": "https://images.unsplash.com/photo-1545558014-8692077e9b5c?auto=format&fit=crop&w=1000&q=80",
    "tags": "test, api, curl, ayurveda, updated",
    "published": true,
    "featured": true
  }' | head -c 200
echo -e "\n✅ Test completed\n"

# Test 10: Search all blogs (Admin)
echo "10. Testing GET /api/blogs/admin/search?keyword=test - Admin search"
curl -s -X GET "$BASE_URL/admin/search?keyword=test" -H "Accept: application/json" | head -c 200
echo -e "\n✅ Test completed\n"

# Test 11: Generate slug utility
echo "11. Testing GET /api/blogs/admin/generate-slug - Generate slug utility"
curl -s -X GET "$BASE_URL/admin/generate-slug?title=My%20Amazing%20New%20Blog%20Post" -H "Accept: application/json"
echo -e "\n✅ Test completed\n"

# Test 12: Check slug availability
echo "12. Testing GET /api/blogs/admin/check-slug - Check slug availability"
curl -s -X GET "$BASE_URL/admin/check-slug?slug=non-existent-slug" -H "Accept: application/json"
echo -e "\n✅ Test completed\n"

# Test 13: Delete blog (Admin) - deleting the test blog we created
echo "13. Testing DELETE /api/blogs/admin/3 - Delete blog"
curl -s -X DELETE "$BASE_URL/admin/3" -H "Accept: application/json"
echo -e "\n✅ Test completed\n"

echo "🎉 Blog API Testing Complete!"
echo ""
echo "📋 Summary of Endpoints Tested:"
echo "   ✓ GET /api/blogs/public - Get published blogs"
echo "   ✓ GET /api/blogs/public/featured - Get featured blogs"  
echo "   ✓ GET /api/blogs/public/slug/{slug} - Get blog by slug"
echo "   ✓ GET /api/blogs/public/search - Search published blogs"
echo "   ✓ GET /api/blogs/public/author/{author} - Get blogs by author"
echo "   ✓ GET /api/blogs/admin - Get all blogs (admin)"
echo "   ✓ GET /api/blogs/admin/{id} - Get blog by ID (admin)"
echo "   ✓ POST /api/blogs/admin - Create blog (admin)"
echo "   ✓ PUT /api/blogs/admin/{id} - Update blog (admin)"
echo "   ✓ DELETE /api/blogs/admin/{id} - Delete blog (admin)"
echo "   ✓ GET /api/blogs/admin/search - Search all blogs (admin)"
echo "   ✓ GET /api/blogs/admin/generate-slug - Generate slug utility"
echo "   ✓ GET /api/blogs/admin/check-slug - Check slug availability"
echo ""