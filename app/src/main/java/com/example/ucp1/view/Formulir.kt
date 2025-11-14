package com.example.ucp1.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.ucp1.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulirPage(
    OnBackBtnClick : () -> Unit,
    OnIyaBtnClick : () -> Unit
){
    var namaDosen by remember { mutableStateOf("") }
    var materi by remember { mutableStateOf("") }
    val presensiList = listOf("08:50 - 11:30", "13:20 - 16:20")
    var expandedPresensi by remember { mutableStateOf(false) }
    var selectedPresensi by remember { mutableStateOf("") }

    var namaDS by remember { mutableStateOf("") }
    var mtr by remember { mutableStateOf("") }
    var prsn by remember { mutableStateOf("") }
    var mkl by remember { mutableStateOf("") }
    var akl by remember { mutableStateOf("") }


    val mkList = listOf("PAM", "PAW", "WebDev", "Cyber Security", "PGM")
    val aktList = listOf("23-Kelas A", "23-Kelas B", "23 Kelas C", "23-Kelas D", "23-Kelas E")
    var expanded by remember { mutableStateOf(false) }
    var expandedd by remember { mutableStateOf(false) }
    var selectedMK by remember { mutableStateOf("") }
    var selectedAK by remember { mutableStateOf("") }
    var showDialogValidasi by remember { mutableStateOf(value = false) }
    var showErrorDialog by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Scaffold(containerColor = Color.Blue,
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Tambah Presensi",
                            fontSize = 35.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Blue,
                            modifier = Modifier
                                .padding(top = 50.dp, bottom = 40.dp)
                            )
                    }
                }
            )
        }
    ) {
        isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
        ) {
            ElevatedCard(
                modifier = Modifier.padding(top = 40.dp, start = 10.dp, end = 10.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White.copy(alpha = 0.5f))
            ) {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = {expanded = !expanded}
                ) {
                    OutlinedTextField(
                        value = selectedMK,
                        onValueChange = {},
                        readOnly = true,
                        colors = OutlinedTextFieldDefaults.colors(Color.White),
                        shape = MaterialTheme.shapes.medium,
                        label ={
                            Text(
                                text = "Nama Matkul",
                                color = Color.White.copy(alpha = 0.5f)
                            )
                        },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        modifier = Modifier.fillMaxWidth().menuAnchor()
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp).height(height = 70.dp)
                    )

                    ExposedDropdownMenu(
                        containerColor = Color.White,
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        mkList.forEach { matkul ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = matkul,
                                        color = Color.Black
                                    )
                                },
                                onClick = {selectedMK = matkul
                                expanded = false}
                            )
                        }
                    }
                }
                ExposedDropdownMenuBox(
                    expanded = expandedd,
                    onExpandedChange = {expandedd = !expandedd}
                ) {
                    OutlinedTextField(
                        value = selectedAK,
                        onValueChange = {},
                        readOnly = true,
                        colors = OutlinedTextFieldDefaults.colors(Color.White),
                        shape = MaterialTheme.shapes.medium,
                        label ={
                            Text(
                                text = "Pilih Kelas",
                                color = Color.White.copy(alpha = 0.5f)
                            )
                        },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedd) },
                        modifier = Modifier.fillMaxWidth().menuAnchor()
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp).height(height = 70.dp)
                    )

                    ExposedDropdownMenu(
                        containerColor = Color.White,
                        expanded = expandedd,
                        onDismissRequest = { expandedd = false }
                    ) {
                        aktList.forEach { aktkls ->
                            DropdownMenuItem(
                                text = {
                                    Text(
                                        text = aktkls,
                                        color = Color.Black
                                    )
                                },
                                onClick = {selectedAK = aktkls
                                    expandedd = false}
                            )
                        }
                    }
                }

                ExposedDropdownMenuBox(
                    expanded = expandedPresensi,
                    onExpandedChange = { expandedPresensi = !expandedPresensi }
                ) {
                    OutlinedTextField(
                        value = selectedPresensi,
                        onValueChange = {},
                        readOnly = true,
                        colors = OutlinedTextFieldDefaults.colors(Color.White),
                        shape = MaterialTheme.shapes.medium,
                        label = {
                            Text("Presensi", color = Color.White.copy(alpha = 0.5f))
                        },
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedPresensi) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor()
                            .padding(start = 20.dp, end = 20.dp, top = 10.dp)
                            .height(70.dp)
                    )

                    ExposedDropdownMenu(
                        containerColor = Color.White,
                        expanded = expandedPresensi,
                        onDismissRequest = { expandedPresensi = false }
                    ) {
                        presensiList.forEach { jam ->
                            DropdownMenuItem(
                                text = { Text(jam, color = Color.Black) },
                                onClick = {
                                    selectedPresensi = jam
                                    expandedPresensi = false
                                }
                            )
                        }
                    }
                }

                OutlinedTextField(
                    value = namaDosen,
                    onValueChange = { namaDosen = it },
                    colors = OutlinedTextFieldDefaults.colors(Color.White),
                    shape = MaterialTheme.shapes.medium,
                    label ={
                        Text(
                            text = "Nama Dosen",
                            color = Color.White.copy(alpha = 0.5f)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp).height(height = 70.dp)
                )

                OutlinedTextField(
                    value = materi,
                    onValueChange = { materi = it },
                    colors = OutlinedTextFieldDefaults.colors(Color.White),
                    shape = MaterialTheme.shapes.medium,
                    label ={
                        Text(
                            text = "Materi",
                            color = Color.White.copy(alpha = 0.5f)
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp, bottom = 20.dp).height(height = 70.dp)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    ElevatedButton(
                        modifier = Modifier
                            .width(160.dp).padding(bottom = 30.dp, top = 30.dp).height(60.dp),
                        shape = MaterialTheme.shapes.small,
                        onClick = OnBackBtnClick
                    ) {
                        Text(
                            text = "BACK",
                            color = Color.Blue,
                            fontSize = 20.sp
                        )
                    }

                    ElevatedButton(
                        modifier = Modifier
                            .width(160.dp).padding(bottom = 30.dp, top = 30.dp).height(60.dp),
                        shape = MaterialTheme.shapes.small,
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                        onClick = {
                            if (namaDosen.isBlank() || materi.isBlank() || selectedMK.isBlank() || selectedAK.isBlank() || materi.isBlank()) {
                                errorMessage = "Harap isi semua data terlebih dahulu!"
                                showErrorDialog = true
                            } else {
                                mkl = selectedMK
                                akl = selectedAK
                                prsn = selectedPresensi
                                namaDS = namaDosen
                                mtr = materi

                                showDialogValidasi = true
                            }
                        }
                    ) {
                        Text(
                            text = "ADD",
                            color = Color.White,
                            fontSize = 20.sp
                        )
                    }
                }

                if (showErrorDialog) {
                    AlertDialog(
                        onDismissRequest = { showErrorDialog = false },
                        containerColor = Color.Red.copy(alpha = 0.9f),
                        title = {
                            Text(
                                text = "Data Belum Lengkap!",
                                fontWeight = FontWeight.Bold,
                                color = Color.White,
                                fontSize = 22.sp
                            )
                        },
                        text = {
                            Text(errorMessage, color = Color.White)
                        },
                        confirmButton = {
                            Button(
                                onClick = { showErrorDialog = false },
                                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                            ) {
                                Text("OK", color = Color.Red)
                            }
                        }
                    )
                }
            }

                if (showDialogValidasi) {
                    AlertDialog(
                        onDismissRequest = { showDialogValidasi = false },
                        title = { Text("Konfirmasi") },
                        text = {
                            Column {
                                Text("Nama Matkul: $selectedMK")
                                Text("Angkatan dan Kelas: $selectedAK")
                                Text("Jam Presensi: $selectedPresensi")
                                Text("Nama Dosen: $namaDosen")
                                Text("Materi: $materi")
                                Text("Apakah semua data sudah benar?")
                            }
                               },
                        confirmButton = {
                            ElevatedButton(onClick = {
                                showDialogValidasi = false
                                OnIyaBtnClick()
                            }) {
                                Text("IYA")
                            }
                        },
                        dismissButton = {
                            ElevatedButton(onClick = { showDialogValidasi = false }) {
                                Text("TIDAK")
                            }
                        }
                    )
                }
            }
        }
    }