package com.example.ucp1.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormLogin(
    OnLoginBtnClick : () -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var namaLengkap by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val validasi = remember { mutableStateOf(false) }

    Scaffold(
        containerColor = Color.DarkGray,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Form Login",
                            color = Color.DarkGray,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Serif,
                            fontSize = 35.sp,
                            modifier = Modifier
                                .padding(top = 60.dp, bottom = 50.dp)
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.height(190.dp)) {
                ElevatedButton(
                    modifier = Modifier
                        .width(width = 160.dp).padding(bottom = 30.dp).height(height = 60.dp)
                        .offset(x = 130.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 5.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                    enabled = validasi.value,
                    onClick =
                        OnLoginBtnClick
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang).padding(start = 16.dp, end = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = namaLengkap,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(top = 100.dp, start = 60.dp),
                label = {
                    Text(
                        text = "Isikan nama lengkap",
                        color = Color.White
                    )
                },
                onValueChange = { namaLengkap = it }
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            OutlinedTextField(
                value = password,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(start = 60.dp),
                label = {
                    Text(
                        text = "Masukkan password",
                        color = Color.White
                    )
                },
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.padding(top = 30.dp))

            Row {
                Checkbox(
                    checked = validasi.value,
                    colors = CheckboxDefaults.colors(uncheckedColor = Color.White),
                    onCheckedChange = { newvalue ->
                        validasi.value = newvalue
                        if (newvalue){
                            showDialog = true
                        }
                    },
                )
                Text(
                    text = "Saya sudah mengisi semua form",
                    fontSize = 15.sp,
                    color = Color.White,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = {showDialog = false},
                    containerColor = Color.White,
                    title ={
                        Text(
                            text = "Menyetujui syarat & ketentuan",
                            fontWeight = FontWeight.Bold
                        )
                    },
                    confirmButton = {
                        Button(
                            onClick = {showDialog = false
                                      validasi.value = true},
                            colors = ButtonDefaults.buttonColors(Color.DarkGray)
                        ) {
                            Text(text = "OK")
                        }
                    }
                )
            }
        }
    }
}