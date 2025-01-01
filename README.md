# OAuth Login Guide

## Introduction
This document explains how to integrate OAuth-based login for authentication in your application.
 OAuth allows secure API authorization without exposing user credentials.

---

## Prerequisites
Before implementing OAuth login, ensure the following:
- You have registered your application with the desired OAuth provider (Google).
- You have obtained the **Client ID** and **Client Secret** from the provider.
- Your application has a valid **Redirect URI** registered with the provider.

---

## Implementation Steps

### 1. Register Your Application
1. Go to the OAuth provider's developer portal.
2. Create a new application and provide the necessary details:
   - Application Name
   - Redirect URI(s)
3. Note down the generated **Client ID** and **Client Secret**.
4. Then put the the Client ID and Client Secret in application.properties file.
5. Run The Spring Boot Project.