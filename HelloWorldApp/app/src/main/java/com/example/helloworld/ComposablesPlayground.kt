package com.example.helloworld

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposablesPlayground() {
    // Scaffold - Layout that provides basic screen structure
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Composables Playground") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // ===== 1. TEXT COMPOSABLE =====
            SectionTitle("1. Text Composable")

            // Basic text
            Text(text = "Basic Text")

            // Styled text
            Text(
                text = "Bold & Large Text",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            // Italic and underline
            Text(
                text = "Italic with Underline",
                fontStyle = FontStyle.Italic,
                textDecoration = TextDecoration.Underline
            )

            // Center aligned text
            Text(
                text = "Centered Text with Background",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp),
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 2. BUTTON COMPOSABLE =====
            SectionTitle("2. Button Composable")

            // Basic button
            Button(onClick = { }) {
                Text("Basic Button")
            }

            // Button with icon
            Button(onClick = { }) {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Button with Icon")
            }

            // Horizontal button arrangement with Row
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Outlined Button
                OutlinedButton(onClick = { }) {
                    Text("Outlined")
                }

                // Text Button
                TextButton(onClick = { }) {
                    Text("Text Button")
                }
            }

            // Filled Tonal Button
            FilledTonalButton(
                onClick = { },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Full Width Tonal Button")
            }

            // Elevated Button
            ElevatedButton(onClick = { }) {
                Icon(Icons.Default.Star, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Elevated Button")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 3. MODIFIER EXAMPLES =====
            SectionTitle("3. Modifier Examples")

            // Padding
            Text(
                text = "Padding: 16.dp all sides",
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
            )

            // Border
            Text(
                text = "Border with rounded corners",
                modifier = Modifier
                    .border(
                        width = 2.dp,
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(12.dp)
                    )
                    .padding(12.dp)
            )

            // Gradient Background
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color(0xFF6200EE),
                                Color(0xFF03DAC5)
                            )
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Gradient Background",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }

            // Shadow
            Box(
                modifier = Modifier
                    .shadow(
                        elevation = 8.dp,
                        shape = RoundedCornerShape(16.dp)
                    )
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Text("Box with Shadow")
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 4. COLUMN & ROW =====
            SectionTitle("4. Column & Row Layout")

            // Row example
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        MaterialTheme.colorScheme.surfaceVariant,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Left")
                Text("Center")
                Text("Right")
            }

            // Nested Column & Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFE3F2FD), RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Column 1", fontWeight = FontWeight.Bold)
                    Text("Item A")
                    Text("Item B")
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .background(Color(0xFFFCE4EC), RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Column 2", fontWeight = FontWeight.Bold)
                    Text("Item X")
                    Text("Item Y")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 5. CARD =====
            SectionTitle("5. Card Composable")

            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Card Title",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "This is the card content. Cards are surfaces that display content and actions on a single topic.",
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        TextButton(onClick = { }) {
                            Text("Cancel")
                        }
                        TextButton(onClick = { }) {
                            Text("OK")
                        }
                    }
                }
            }

            // Outlined Card
            OutlinedCard(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primary),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("JD", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("John Doe", fontWeight = FontWeight.Medium)
                        Text(
                            "john.doe@email.com",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 6. BOX =====
            SectionTitle("6. Box Composable (Stacking)")

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFE8EAF6), RoundedCornerShape(12.dp))
            ) {
                // Background text (behind)
                Text(
                    text = "Background Layer",
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(8.dp),
                    color = Color.Gray
                )
                // Center box
                Box(
                    modifier = Modifier
                        .size(80.dp)
                        .align(Alignment.Center)
                        .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(8.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Center", color = Color.White)
                }
                // Bottom-right badge
                Badge(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                ) {
                    Text("New")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 7. TEXTFIELD =====
            SectionTitle("7. TextField Composable")

            var text1 by remember { mutableStateOf("") }
            var text2 by remember { mutableStateOf("") }

            // Basic TextField
            TextField(
                value = text1,
                onValueChange = { text1 = it },
                label = { Text("Basic TextField") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Outlined TextField with icon
            OutlinedTextField(
                value = text2,
                onValueChange = { text2 = it },
                label = { Text("Email") },
                placeholder = { Text("Enter your email") },
                leadingIcon = {
                    Icon(Icons.Default.Email, contentDescription = null)
                },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            // ===== 8. SPACER EXAMPLES =====
            SectionTitle("8. Spacer Examples")

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text("Left")
                Spacer(modifier = Modifier.weight(1f)) // Takes remaining space
                Text("Right")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFF5F5F5), RoundedCornerShape(8.dp))
                    .padding(8.dp)
            ) {
                Text("Top")
                Spacer(modifier = Modifier.height(24.dp)) // Fixed height
                Text("Bottom (24.dp gap)")
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
private fun SectionTitle(title: String) {
    Text(
        text = title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 8.dp)
    )
    HorizontalDivider()
    Spacer(modifier = Modifier.height(8.dp))
}

// ===== PREVIEW =====
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ComposablesPlaygroundPreview() {
    HelloWorldAppTheme {
        ComposablesPlayground()
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Dark Mode")
@Composable
fun ComposablesPlaygroundDarkPreview() {
    HelloWorldAppTheme(darkTheme = true) {
        ComposablesPlayground()
    }
}
