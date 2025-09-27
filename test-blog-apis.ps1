# Complete Blog API Test Script
# Make sure your Spring Boot application is running on localhost:8080

Write-Host "🚀 Testing Blog APIs..." -ForegroundColor Green
Write-Host ""

# Base URL
$baseUrl = "http://localhost:8080/api/blogs"

# Test 1: Get all published blogs (Public)
Write-Host "1. Testing GET /api/blogs/public - Get all published blogs" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/public" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) published blogs" -ForegroundColor Green
    if ($response.Count -gt 0) {
        Write-Host "   First blog: $($response[0].title)" -ForegroundColor Yellow
    }
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 2: Get featured blogs
Write-Host "2. Testing GET /api/blogs/public/featured - Get featured blogs" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/public/featured" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) featured blogs" -ForegroundColor Green
    if ($response.Count -gt 0) {
        Write-Host "   Featured blog: $($response[0].title)" -ForegroundColor Yellow
    }
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 3: Get blog by slug (Public)
Write-Host "3. Testing GET /api/blogs/public/slug/{slug} - Get blog by slug" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/public/slug/acne-causes-signs-ayurvedic-treatment" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Retrieved blog '$($response.title)'" -ForegroundColor Green
    Write-Host "   Author: $($response.author)" -ForegroundColor Yellow
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 4: Search published blogs
Write-Host "4. Testing GET /api/blogs/public/search?keyword=acne - Search blogs" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/public/search?keyword=acne" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) blogs matching 'acne'" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 5: Get blogs by author
Write-Host "5. Testing GET /api/blogs/public/author/{author} - Get blogs by author" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/public/author/Dr.%20Axico" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) blogs by Dr. Axico" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# ADMIN ENDPOINTS
Write-Host "🔐 ADMIN ENDPOINTS" -ForegroundColor Magenta
Write-Host ""

# Test 6: Get all blogs (Admin)
Write-Host "6. Testing GET /api/blogs/admin - Get all blogs (admin)" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) total blogs" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 7: Get blog by ID (Admin)
Write-Host "7. Testing GET /api/blogs/admin/1 - Get blog by ID" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin/1" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Retrieved blog '$($response.title)'" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 8: Create new blog (Admin)
Write-Host "8. Testing POST /api/blogs/admin - Create new blog" -ForegroundColor Cyan
$newBlog = @{
    title = "Test Blog from PowerShell"
    slug = "test-blog-powershell"
    content = "This is a test blog created using PowerShell script to test the API endpoints. It covers basic Ayurvedic principles and natural healing methods."
    summary = "A test blog created via PowerShell to verify API functionality"
    author = "API Tester"
    imageUrl = "https://images.unsplash.com/photo-1545558014-8692077e9b5c?auto=format&fit=crop&w=1000&q=80"
    tags = "test, api, powershell, ayurveda"
    published = $true
    featured = $false
} | ConvertTo-Json

try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin" -Method Post -Body $newBlog -ContentType "application/json"
    Write-Host "✅ Success: Created blog with ID $($response.id) - '$($response.title)'" -ForegroundColor Green
    $createdBlogId = $response.id
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
    $createdBlogId = $null
}
Write-Host ""

# Test 9: Update blog (Admin) - only if creation was successful
if ($createdBlogId) {
    Write-Host "9. Testing PUT /api/blogs/admin/$createdBlogId - Update blog" -ForegroundColor Cyan
    $updateBlog = @{
        title = "Updated Test Blog from PowerShell"
        slug = "updated-test-blog-powershell"
        content = "This is an UPDATED test blog created using PowerShell script. The content has been modified to test the update functionality."
        summary = "Updated test blog to verify API update functionality"
        author = "API Tester Updated"
        imageUrl = "https://images.unsplash.com/photo-1545558014-8692077e9b5c?auto=format&fit=crop&w=1000&q=80"
        tags = "test, api, powershell, ayurveda, updated"
        published = $true
        featured = $true
    } | ConvertTo-Json

    try {
        $response = Invoke-RestMethod -Uri "$baseUrl/admin/$createdBlogId" -Method Put -Body $updateBlog -ContentType "application/json"
        Write-Host "✅ Success: Updated blog '$($response.title)'" -ForegroundColor Green
    } catch {
        Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
    }
    Write-Host ""
}

# Test 10: Search all blogs (Admin)
Write-Host "10. Testing GET /api/blogs/admin/search?keyword=test - Admin search" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin/search?keyword=test" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Found $($response.Count) blogs matching 'test'" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 11: Generate slug utility
Write-Host "11. Testing GET /api/blogs/admin/generate-slug - Generate slug utility" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin/generate-slug?title=My Amazing New Blog Post" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Generated slug: '$response'" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 12: Check slug availability
Write-Host "12. Testing GET /api/blogs/admin/check-slug - Check slug availability" -ForegroundColor Cyan
try {
    $response = Invoke-RestMethod -Uri "$baseUrl/admin/check-slug?slug=non-existent-slug" -Method Get -ContentType "application/json"
    Write-Host "✅ Success: Slug availability: $response" -ForegroundColor Green
} catch {
    Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
}
Write-Host ""

# Test 13: Delete blog (Admin) - only if we created one
if ($createdBlogId) {
    Write-Host "13. Testing DELETE /api/blogs/admin/$createdBlogId - Delete blog" -ForegroundColor Cyan
    try {
        Invoke-RestMethod -Uri "$baseUrl/admin/$createdBlogId" -Method Delete -ContentType "application/json"
        Write-Host "✅ Success: Deleted blog with ID $createdBlogId" -ForegroundColor Green
    } catch {
        Write-Host "❌ Failed: $($_.Exception.Message)" -ForegroundColor Red
    }
    Write-Host ""
}

Write-Host "🎉 Blog API Testing Complete!" -ForegroundColor Green
Write-Host ""
Write-Host "📋 Summary of Endpoints Tested:" -ForegroundColor Yellow
Write-Host "   ✓ GET /api/blogs/public - Get published blogs"
Write-Host "   ✓ GET /api/blogs/public/featured - Get featured blogs"
Write-Host "   ✓ GET /api/blogs/public/slug/{slug} - Get blog by slug"
Write-Host "   ✓ GET /api/blogs/public/search - Search published blogs"
Write-Host "   ✓ GET /api/blogs/public/author/{author} - Get blogs by author"
Write-Host "   ✓ GET /api/blogs/admin - Get all blogs (admin)"
Write-Host "   ✓ GET /api/blogs/admin/{id} - Get blog by ID (admin)"
Write-Host "   ✓ POST /api/blogs/admin - Create blog (admin)"
Write-Host "   ✓ PUT /api/blogs/admin/{id} - Update blog (admin)"
Write-Host "   ✓ DELETE /api/blogs/admin/{id} - Delete blog (admin)"
Write-Host "   ✓ GET /api/blogs/admin/search - Search all blogs (admin)"
Write-Host "   ✓ GET /api/blogs/admin/generate-slug - Generate slug utility"
Write-Host "   ✓ GET /api/blogs/admin/check-slug - Check slug availability"
Write-Host ""