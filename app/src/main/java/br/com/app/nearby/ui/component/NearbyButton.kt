package br.com.app.nearby.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import br.com.app.nearby.R
import br.com.app.nearby.ui.theme.GreenBase
import br.com.app.nearby.ui.theme.Typography

// modifier: controla toda a parte visual e de comportamento dos elementos
@Composable
fun NearbyButton(modifier: Modifier = Modifier,
                 text: String? = null,
                 @DrawableRes iconsRes: Int? = null, // recebe um identificados de um elemento drawable
                 onClick: () -> Unit,  // ação de click no botão
                 ) {
    Button(modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconsRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        ),
        onClick = onClick
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconsRes?.let {
                Icon(painter = painterResource(id = iconsRes), contentDescription = "Ícone do botão")
            }
            text?.let { Text(text = text.uppercase(), style = Typography.labelLarge) }
        }
    }

}

@Preview
@Composable
private fun NearbyButtonPreview() {
    NearbyButton (
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        iconsRes = R.drawable.ic_scan
    ) {  }
}

@Preview
@Composable
private fun NearbyButtonNoIconPreview() {
    NearbyButton (
        modifier = Modifier.fillMaxWidth(),
        text = "Confirmar"
    ) {  }
}

@Preview
@Composable
private fun NearbyButtonNoTextPreview() {
    NearbyButton (
        modifier = Modifier,
        iconsRes = R.drawable.ic_arrow_left
    ) {  }
}